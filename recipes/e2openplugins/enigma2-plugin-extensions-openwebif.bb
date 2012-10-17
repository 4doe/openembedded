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
						 file://twin.jpg \
						 file://twin.png \
						 "

SRC_URI_append_tm2toe = " \
						 file://base.py \
						 file://info.py \
						 file://2t.html \
						 file://2t.jpg \
						 file://2t.png \
						 "
SRC_URI_append_tmsignle = " \
						 file://base.py \
						 file://info.py \
						 file://single.html \
						 file://single.jpg \
						 file://single.png \
						 "
SRC_URI_append_ios100 = " \
						file://base.py \
						file://info.py \
						file://ios200hd.jpg \
						file://ios200hd.png \
						file://ios200hd.html \
						 "
SRC_URI_append_ios200 = " \
						file://base.py \
						file://info.py \
						file://ios200hd.jpg \
						file://ios200hd.png \
						file://ios200hd.html \
						 "
SRC_URI_append_ios300 = " \
						file://base.py \
						file://info.py \
						file://ios300hd.jpg \
						file://ios300hd.png \
						file://ios300hd.html \
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
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/twin.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/twin.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/twin.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tm2toe () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/2t.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/2t.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/2t.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tmsingle () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/single.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/single.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/single.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_ios100 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/ios100hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/ios100hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/ios100hd.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_ios200 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/ios200hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/ios200hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/ios200hd.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_ios300 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${S}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${S}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${S}/ios300hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${S}/ios300hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${S}/ios300hd.html ${D}${PLUGINPATH}/public/static/remotes/
}

FILES_${PN} = "${PLUGINPATH}"
