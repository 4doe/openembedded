require linux-technomate-3.1.1.inc

MACHINE_KERNEL_PR_append = ".8"

SRC_URL += "\
			file://001_fix_standby_error.patch;striplevel=1 \
			"

