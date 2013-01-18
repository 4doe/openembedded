DESCRIPTION = "Alsa sound library"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1"

# configure.in sets -D__arm__ on the command line for any arm system
# (not just those with the ARM instruction set), this should be removed,
# (or replaced by a permitted #define).
#FIXME: remove the following
ARM_INSTRUCTION_SET = "arm"

#SRC_URI = "ftp://ftp.alsa-project.org/pub/lib/alsa-lib-${PV}.tar.bz2 \
SRC_URI = "http://opengit.homelinux.com/pub/OpenPLi/src/alsa-lib-${PV}.tar.bz2 \
           file://fix-tstamp-declaration.patch \
           file://fix_libmath.patch \
	  "

SRC_URI[md5sum] = "7cc05f25e1d5b65da8fb3fdcd540f226"
SRC_URI[sha256sum] = "a32f7c21015b6c71f9a80ff70a2b6a50e4ff4d5c77c744ff0793dea7ba7a2517"

inherit autotools pkgconfig


EXTRA_OECONF = "--with-cards=pdaudiocf --with-oss=yes --disable-python --enable-shared --enable-static"


require alsa-fpu.inc
EXTRA_OECONF += "${@get_alsa_fpu_setting(bb, d)} "


require alsa-versym.inc
EXTRA_OECONF += "${@get_alsa_versym_setting(bb, d)} "


PACKAGES =+ "alsa-server libasound alsa-conf-base alsa-conf alsa-doc alsa-dev"
FILES_${PN}-dbg += "${libdir}/alsa-lib/*/.debu*"
FILES_libasound = "${libdir}/libasound.so.*"
FILES_alsa-server = "${bindir}/*"
FILES_alsa-conf = "${datadir}/alsa/"
FILES_alsa-dev += "${libdir}/libasound.so ${libdir}/pkgconfig/ /usr/include/ ${datadir}/aclocal/*"
FILES_alsa-conf-base = "\
${datadir}/alsa/alsa.conf \
${datadir}/alsa/cards/aliases.conf \
${datadir}/alsa/pcm/default.conf \
${datadir}/alsa/pcm/dmix.conf \
${datadir}/alsa/pcm/dsnoop.conf"

RDEPENDS_libasound = "alsa-conf-base"

