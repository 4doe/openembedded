DESCRIPTION = "Configuration files for online package repositories aka feeds"
PR = "r1"

DISTRO_FEED_PREFIX ?= "remote"
DISTRO_FEED_URI ?= "http://my-distribution.example/remote-feed/"
DISTRO_FEED_URI_Openembedded ?= "http://en2.ath.cx/Openembedded/${feed}"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg
	if [ "${MACHINE}" == "tmtwin" ];then
		for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "tm2toe" ];then
		for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios100" ];then
		for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios200" ];then
		for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios300" ];then
		for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	else
	    for feed in all ${TARGET_ARCH} ${PACKAGE_EXTRA_ARCHS} ${MACHINE_ARCH}; do
    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
		done
	fi
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644 ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

#def distro_feed_configs(d):
#    import bb
#    parchs = bb.data.getVar( "PACKAGE_EXTRA_ARCHS", d, 1 ).split()
#    march = bb.data.getVar( "MACHINE_ARCH", d, 1 ).split()
#    archs = [ "all" ] + parchs + march
#    confs = [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in archs ]
#    return " ".join( confs )
#
#CONFFILES_${PN} += '${@distro_feed_configs(d)}'

CONFFILES_${PN} += '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "all ${PACKAGE_EXTRA_ARCHS} ${MACHINE_ARCH}".split() ] ) }'
