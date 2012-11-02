DESCRIPTION = "PLi HD skin"
MAINTAINER = "littlesat"

SRCREV_pn-${PN} ?= "${AUTOREV}"
inherit gitpkgv

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0"

PACKAGES = "${PN}"

SRC_URI = "git://github.com/littlesat/skin-PLiHD.git;protocol=git"

SRC_URI_append_tmtwin = " \
						 file://skin.xml \
						 "
SRC_URI_append_tmtwinoe = " \
						 file://skin.xml \
						 "
SRC_URI_append_ios100 = " \
						 file://skin.xml \
						 "
SRC_URI_append_ios200 = " \
						 file://skin.xml \
						 "
SRC_URI_append_ios300 = " \
						 file://skin.xml \
						 "
SRC_URI_append_tm2toe = " \
						 file://skin.xml \
						 "
SRC_URI_append_tmsingle = " \
						 file://skin.xml \
						 "



FILES_${PN} = "/usr/share/enigma2/"

# NOTE : dependency error

#RDEPENDS_${PN} = "font-valis-hd"
S = "${WORKDIR}/git"

do_compile() {
}

do_install_append_tmtwin() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}
do_install_append_tmtwinoe() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}

do_install_append_ios100() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}

do_install_append_ios200() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}

do_install_append_ios300() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}

do_install_append_tm2toe() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}

do_install_append_tmsingle() {
	install -d ${D}/usr/share
	install -d ${D}/usr/share/enigma2/PLi-HD/
	cp -rp ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/
	install -m 0755 ${WORKDIR}/skin.xml ${D}/usr/share/enigma2/PLi-HD/
}
