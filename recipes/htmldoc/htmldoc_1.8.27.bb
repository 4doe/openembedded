require htmldoc.inc
DEPENDS_pn-htmldoc += "htmldoc-native"
PR = "r3"


SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/htmldoc/${PV}/htmldoc-${PV}-source.tar.bz2 \
	file://paths_1.8.27.patch \
	"


inherit autotools pkgconfig

EXTRA_AUTORECONF += "--exclude=autoheader"
EXTRA_OECONF += "--disable-localpng --disable-localjpeg --disable-localzlib \
		--with-gui=no"

FILES_${PN} += "${datadir}/htmldoc/fonts"
FILES_${PN} += "${datadir}/htmldoc/data"

BBCLASSEXTEND = "native"

do_compile_virtclass-native() {
	(cd htmldoc && oe_runmake all)
}
do_install_virtclass-native() {
	(cd fonts && oe_runmake 'DESTDIR=${D}' install)
	(cd data && oe_runmake 'DESTDIR=${D}' install)
	(cd htmldoc && oe_runmake 'DESTDIR=${D}' install)
}

do_install() {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "35589e7b8fe9c54e11be87cd5aec4dcc"
SRC_URI[sha256sum] = "89ffd223734268375dc959c200622dc5f167576c5cad9d7ce4bd7567faeb9613"
