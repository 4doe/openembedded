DESCRIPTION = " the tmtwin Universal bootlogo"
SECTION = "tmtwin bootlogo"

SRC_URI = "file://splash.bmp"

do_compile(){
	mkdir -p ${DEPLOY_DIR_IMAGE}
	cp ${WORKDIR}/splash.bmp .
}

do_install(){
	install -m 0755 ${WORKDIR}/splash.bmp ${DEPLOY_DIR_IMAGE}/${MACHINE}.splash.bmp
}
