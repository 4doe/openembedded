DESCRIPTION = "Hardware drivers for tmtwin"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

KV = "3.1.1"
PV = "${KV}"

SRCDATE = "20121030"

RDEPENDS = "kernel (${KV})" 
RDEPENDS += "technomate-bootloader"
RDEPENDS += "technomate-logo"
RDEPENDS += "cccam-config"

MACHINE_KERNEL_PR_append = ".${SRCDATE}.0"

TECHNOMATE_KERNEL_GCC = "4.4.3"
DOWNLOADMACHINE = "${MACHINE}"

# NOTE : comment :if module install inherit
inherit module

#SRC_URI = "http://archive.vuplus.com/download/drivers/vuplus-dvb-modules-${DOWNLOADMACHINE}-${KV}-${VUPLUS_KERNEL_GCC}-${SRCDATE}.tar.gz"
SRC_URI = "http://opengit.homelinux.com/pub/download/drivers/technomate-dvb-modules-${MACHINE}-${KV}-${TECHNOMATE_KERNEL_GCC}-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

do_compile() {
}

do_strip_modules() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    for f in *.ko; do
        install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
    done
    install -d ${D}/${sysconfdir}/modutils
    for i in `ls | grep \\.ko | sed -e 's/.ko//g'`; do
        echo $i >> ${D}/${sysconfdir}/modutils/_vuplus
    done
	if [ "${MACHINE}" == tmsingle ];then
		echo "bcmlinuxdvb _hwtype=\$hwtypenum" > ${D}/${sysconfdir}/modutils/_vuplus
	elif [ "${MACHINE}" == ios300 ];then
		echo "bcmlinuxdvb _hwtype=\$hwtypenum" > ${D}/${sysconfdir}/modutils/_vuplus
	fi
}
