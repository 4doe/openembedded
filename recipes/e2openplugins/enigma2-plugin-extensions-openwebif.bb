MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

DEPENDS = "python-cheetah-native"
RDEPENDS_${PN} = "python-cheetah python-json python-unixadmin python-misc aio-grab python-pyopenssl"

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
SRC_URI_append_tmtwinoe = " \
						 file://base.py \
						 file://info.py \
						 file://twinoe.html \
						 file://twinoe.jpg \
						 file://twinoe.png \
						 "


SRC_URI_append_tm2toe = " \
						 file://base.py \
						 file://info.py \
						 file://2t.html \
						 file://2t.jpg \
						 file://2t.png \
						 "
SRC_URI_append_tmsingle = " \
						 file://base.py \
						 file://info.py \
						 file://single.html \
						 file://single.jpg \
						 file://single.png \
						 "
SRC_URI_append_tmsinglemini = " \
						 file://base.py \
						 file://info.py \
						 file://singlemini.html \
						 file://singlemini.jpg \
						 file://singlemini.png \
						 "

SRC_URI_append_ios100 = " \
						file://base.py \
						file://info.py \
						file://ios100hd.jpg \
						file://ios100hd.png \
						file://ios100hd.html \
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
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/twin.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/twin.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/twin.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tmtwinoe () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/twinoe.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/twinoe.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/twinoe.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tm2toe () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/2t.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/2t.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/2t.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tmsingle () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/single.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/single.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/single.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_tmsinglemini () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/singlemini.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/singlemini.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/singlemini.html ${D}${PLUGINPATH}/public/static/remotes/
}

do_install_append_ios100 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/ios100hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/ios100hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/ios100hd.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_ios200 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/ios200hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/ios200hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/ios200hd.html ${D}${PLUGINPATH}/public/static/remotes/
}
do_install_append_ios300 () {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	cp -rp ${WORKDIR}/base.py ${D}${PLUGINPATH}/controllers/
	cp -rp ${WORKDIR}/info.py ${D}${PLUGINPATH}/controllers/models/
	cp -rp ${WORKDIR}/ios300hd.jpg ${D}${PLUGINPATH}/public/images/boxes/
	cp -rp ${WORKDIR}/ios300hd.png ${D}${PLUGINPATH}/public/images/remotes/
	cp -rp ${WORKDIR}/ios300hd.html ${D}${PLUGINPATH}/public/static/remotes/
}

FILES_${PN} = "${PLUGINPATH}"
