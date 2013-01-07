DESCRIPTION = "Handle your EPG on enigma2 from various sources (opentv, mhw, xmltv, custom sources)"
HOMEPAGE = "https://github.com/E2OpenPlugins/e2openplugin-CrossEPG"
MODULE = "CrossEPG"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "libxml2 zlib python python-native"

# it sometime fails to build in parallel
PARALLEL_MAKE = ""

inherit gitpkgv
SRCREV = ""
PV = "0.6.2+git${SRCPV}"
PKGV = "0.6.2+git${GITPKGV}"
PR = "r0"

inherit python-dir

require openplugins.inc

SRC_URI_append_tmtwin = " \
						file://crossepg_menu.py \
						file://plugin.py \
						 "
SRC_URI_append_tmtwinoe = " \
						file://crossepg_menu.py \
						file://plugin.py \
						 "

SRC_URI_append_tm2toe = " \
						file://crossepg_menu.py \ 
						file://plugin.py \
						 "
SRC_URI_append_tmsingle = " \
						file://crossepg_menu.py \ 
						file://plugin.py \
						 "
SRC_URI_append_tmsingle1 = " \
						file://crossepg_menu.py \ 
						file://plugin.py \
						 "
SRC_URI_append_ios100 = " \
						 file://crossepg_menu.py \
						 file://plugin.py \
						 "

SRC_URI_append_ios200 = " \
						 file://crossepg_menu.py \ 
						 file://plugin.py \
						 "
SRC_URI_append_ios300 = " \
						file://crossepg_menu.py \ 
						file://plugin.py \
						 "
#@ NOTE : usr/lib/enigma2/python/Plugins/SystemPlugins/CrossEPG
FILES_${PN} = "/usr/*"
FILES_${PN}-dbg += "/usr/crossepg/scripts/mhw2epgdownloader/.debug"

CFLAGS_append = " -I${STAGING_INCDIR}/libxml2/ -I${STAGING_INCDIR}/${PYTHON_DIR}/"

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/${MODULE}"

do_compile() {
	echo ${PKGV} > ${S}/VERSION
	oe_runmake SWIG="swig"
}

#@ NOTE : divide model.
#do_install() {
#	oe_runmake 'D=${D}' install
#}

do_install_append_tmtwin() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_tmtwinoe() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_tm2toe() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_tmsingle() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_tmsingle1() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}

do_install_append_ios100() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_ios200() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
do_install_append_ios300() {
	oe_runmake 'D=${D}' install
	install -m 0644 ${WORKDIR}/crossepg_menu.py ${D}${PLUGINPATH}/
	install -m 0644 ${WORKDIR}/plugin.py ${D}${PLUGINPATH}/
}
