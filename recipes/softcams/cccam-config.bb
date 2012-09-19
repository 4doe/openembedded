DESCRIPTION = "Softcam config"

PV = "1.0"
PN = "enigma2-plugin-softcams-cccam-config-${PV}"
PR = "r0"

S = "${WORKDIR}"

SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/cccam-config-${PV}.tar.gz"

CONFFILES = "/etc/CCcam.cfg"

do_install() {
	install -d ${D}/etc
	install -m 0644 ${S}/CCcam.cfg ${D}/etc/CCcam.cfg
}




