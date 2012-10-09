MODULE = "PPanel"
DESCRIPTION = "PPanel"

require openplugins-replace-pli.inc

require openplugins-distutils.inc

SRC_URI_append_tmtwin = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "

SRC_URI_append_ios100 = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "

SRC_URI_append_ios200 = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "

SRC_URI_append_ios300 = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "

SRC_URI_append_tm2toe = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "
SRC_URI_append_tmsingle = " \
					file://CCcam.xml \
					file://PPanel_tutorial.xml \
						 "

do_install_append_tmtwin(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}

do_install_append_ios100(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}

do_install_append_ios200(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}

do_install_append_ios300(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}

do_install_append_tm2toe(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}
do_install_append_tmsingle(){
		install -d ${D}/etc/ppanels
		install -m 0755 ${WORKDIR}/CCcam.xml ${D}/etc/ppanels/
		install -m 0755 ${WORKDIR}/PPanel_tutorial.xml ${D}/etc/ppanels/
}

require assume-gplv2.inc
