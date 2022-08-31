#!/bin/bash
set -ex
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb

curl -s -L linux-install-firefox https://raw.githubusercontent.com/tanrax/linux-install-firefox/main/linux-install-firefox | bash