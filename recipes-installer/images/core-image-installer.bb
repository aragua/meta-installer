DESCRIPTION = "An image with Anaconda support."

LICENSE = "MIT"


inherit core-image installer_image

# Support installation from initrd boot
do_image_complete[depends] += "core-image-installer-initramfs:do_image_complete"

DEPENDS += "isomd5sum-native \
"

# We override what gets set in core-image.bbclass
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    ${@['', 'packagegroup-installer-x11-anaconda'][bool(d.getVar('XSERVER', True))]} \
    anaconda \
    anaconda-init \
    kernel-modules \
    virtual/logos \
    dhcp-client \
    ldd \
    "
IMAGE_LINGUAS = "en-us en-gb"

