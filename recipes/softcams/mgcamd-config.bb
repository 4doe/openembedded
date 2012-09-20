DESCRIPTION = " the tmtwin Universal mgcamd-config"

PN = "enigma2-plugin-softcams-mgcamd-config"
PV = "1.30"
PR = "r0"

SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/mgcamd-config-${PV}.tar.gz"

S = ${WORKDIR}

INHIBIT_PACKAGE_STRIP = "1"

do_compile(){
}

do_install() {
	install -d ${D}/usr/keys
	install -m 0644 ${S}/mgcamd-config/usr/keys/peer.cfg ${D}/usr/keys/peer.cfg
	install -m 0644 ${S}/mgcamd-config/usr/keys/ignore.list ${D}/usr/keys/ignore.list
	install -m 0644 ${S}/mgcamd-config/usr/keys/replace.list ${D}/usr/keys/replace.list
	install -m 0644 ${S}/mgcamd-config/usr/keys/newcamd.list ${D}/usr/keys/newcamd.list
	install -m 0644 ${S}/mgcamd-config/usr/keys/mg_cfg ${D}/usr/keys/mg_cfg
	install -m 0644 ${S}/mgcamd-config/usr/keys/priority.list ${D}/usr/keys/priority.list
}

