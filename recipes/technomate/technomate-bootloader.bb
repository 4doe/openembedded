DESCRIPTION = " the tmtwin Universal Boot Loader"
SECTION = "tmtwin bootloaders"

#NOTE : SRCDATE divide to date
#SRCDATE = "20120820"

SRC_URI = "file://cfe.bin"

do_compile(){
	mkdir -p ${DEPLOY_DIR_IMAGE}
	cp ${WORKDIR}/cfe.bin .
}

do_install(){
	install -m 0755 ${WORKDIR}/cfe.bin ${DEPLOY_DIR_IMAGE}/${MACHINE}.cfe.bin
}
