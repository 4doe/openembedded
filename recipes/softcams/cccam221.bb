
DESCRIPTION = "Older CCcam ${PV} softcam"
PN = "enigma2-plugin-softcams-cccam${CCAMV}"
PR = "r0"

CCAMV = "221"
PV = "2.2.1"

SRC_URI = "http://downloads.pli-images.org/softcams/CCcam-${PV}.zip"

CAMNAME = "CCcam${CCAMV}"

S = "${WORKDIR}"

require softcam.inc

INHIBIT_PACKAGE_STRIP = "1"

#CONFFILES = "/etc/CCcam.cfg"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/CCcam.${TARGET_ARCH} ${D}/usr/bin/${CAMNAME}
#	install -d ${D}/etc
#	install -m 0644 ${S}/CCcam.cfg ${D}/etc/CCcam.cfg
}
