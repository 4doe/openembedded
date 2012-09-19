DESCRIPTION = " the tmtwin Universal cccam config"
SECTION = "cccam config"

PV = "1.0"

SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/cccam-config-${PV}.tar.gz"

S = ${WORKDIR}

do_compile(){
}

do_install() {
        install -d ${D}/etc
        install -m 0644 ${S}/etc/CCcam.cfg ${D}/etc/CCcam.cfg
}

