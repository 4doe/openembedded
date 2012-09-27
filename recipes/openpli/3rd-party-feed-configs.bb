DESCRIPTION = "Configuration files for 3rd-party feeds"
PR = "r0"

FEEDS = "3rd-party"

DISTRO_FEED_URI_Openembedded ?= "http://en2.ath.cx/Openembedded/${feed}"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg
	if [ "${MACHINE}" == "tmtwin" ];then
		for feed in ${FEEDS}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "tm2toe" ];then
		for feed in ${FEEDS} ; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios100" ];then
		for feed in ${FEEDS}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios200" ];then
		for feed in ${FEEDS}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	elif [ "${MACHINE}" == "ios300" ];then
		for feed in ${FEEDS}; do
	    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI_Openembedded}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	else
	    for feed in ${FEEDS}; do
    	    echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI}/${feed}" > ${S}${sysconfdir}/opkg/${feed}-feed.conf
		done
	fi
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644 ${S}${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} += '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "${FEEDS}".split() ] ) }'
