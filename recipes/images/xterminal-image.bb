export IMAGE_BASENAME = "xterminal-image"

IMAGE_LINGUAS = ""

XTERMINAL_PACKAGES = "${MACHINE_TASK_PROVIDER} task-xterminal"

IMAGE_INSTALL = "${XTERMINAL_PACKAGES}"
DEPENDS = "${XTERMINAL_PACKAGES}"

inherit image
