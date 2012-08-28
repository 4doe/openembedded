DESCRIPTION = "PNG Library"
HOMEPAGE = "http://www.libpng.org/"
LICENSE = "libpng"
SECTION = "libs"
PRIORITY = "required"

DEPENDS = "zlib"

INC_PR = "r3"

BBCLASSEXTEND = "native"

RPROVIDES += "libpng3"

SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/libpng-${PV}.tar.bz2;name=libpng"
S = "${WORKDIR}/libpng-${PV}"

inherit autotools pkgconfig binconfig

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += " ${bindir} ${sbindir}"
