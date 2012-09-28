MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

DEPENDS = "python-cheetah-native"
RDEPENDS_${PN} = "python-cheetah python-json python-unixadmin python-misc aio-grab"

inherit gitpkgv
PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
PR = "r0.72"

require openplugins.inc

SRC_URI_append_tmtwin = " \
						 file://base.py \
						 file://info.py \
						 file://twin.html \
						 file://TWIN.jpg \
						 file://twin.png \
						 "

SRC_URI_append_tm2toe = " \
						 file://base.py \
						 file://info.py \
						 file://twin.html \
						 file://TWIN.jpg \
						 file://twin.png \
						 "
SRC_URI_append_ios100 = " \
						 file://base.py \
						 file://info.py \
						 file://twin.html \
						 file://TWIN.jpg \
						 file://twin.png \
						 "
SRC_URI_append_ios200 = " \
						 file://base.py \
						 file://info.py \
						 file://twin.html \
						 file://TWIN.jpg \
						 file://twin.png \
						 "
SRC_URI_append_ios300 = " \
						 file://base.py \
						 file://info.py \
						 file://twin.html \
						 file://TWIN.jpg \
						 file://twin.png \
						 "

# Just a quick hack to "compile" it
do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"
#@ NOTE : divide model
#do_install() {
#	install -d ${D}${PLUGINPATH}
#	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
#}
do_install_append_tmtwin () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}
do_install_append_tm2toe () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}
do_install_append_ios100 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}
do_install_append_ios200 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}
do_install_append_ios300 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
}

FILES_${PN} = "${PLUGINPATH}"
