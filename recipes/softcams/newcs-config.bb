DESCRIPTION = " the tmtwin Universal newcs config"

PN = "enigma2-plugin-softcams-newcs-config"
PV = "1.67"
PR = "r0"

SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/newcs-config-${PV}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile(){
}

do_install() {
	install -d ${D}/etc/tuxbox/config
	install -m 0644 ${S}/newcs-config/etc/tuxbox/config/newcs.xml ${D}/etc/tuxbox/config/newcs.xml
}

