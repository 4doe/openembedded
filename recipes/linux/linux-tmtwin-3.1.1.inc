CRIPTION = "Linux kernel for tmtwin"
LICENSE = "GPL"
KV = "3.1.1"

SRCREV = "r8"

MODULE = "linux-3.1.1"

DEPENDS = "mtd-minimal-nand-utils"
RDEPENDS_kernel-image = "mtd-minimal-nand-utils"

SRC_URI += "http://opengit.homelinux.com/pub/download/kernel/linux-${KV}_${SRCREV}.tar.gz \
	file://${MACHINE}_defconfig \
		"

S = "${WORKDIR}/linux-${KV}"

inherit kernel


export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

FILES_kernel-image = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz"



do_configure_prepend() {
		oe_machinstall -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${S}/.config
		oe_runmake oldconfig
}

kernel_do_install_append() {
		install -d ${D}/${KERNEL_IMAGEDEST}
		install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
		gzip ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

pkg_postinst_kernel-image () {
		if [ -d /proc/stb ] ; then
				flash_eraseall -j /dev/mtd6
				nandwrite -p /dev/mtd6 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
		fi
		rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
		true
}

