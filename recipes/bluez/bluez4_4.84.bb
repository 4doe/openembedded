require bluez4.inc

#SRC_URI[md5sum] = "95e66f26f69aa425d27718f487b6bc74"
#SRC_URI[sha256sum] = "2913b0b09738295547c1bfdcca9e1da456c9ad6950cc499b1ee83b330bf8a5b6"

SRC_URI[md5sum] = "fd2586143e2d87ee5cb1474cf2d6a221"
SRC_URI[sha256sum] = "7dac3fb1c6d92fd86e5d98923c4da48b14fffec7b327f9008cacd1ca7777f371"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"

EXTRA_OECONF += "${BTUDEV}"
