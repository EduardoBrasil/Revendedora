# -*- mode: ruby -*-
# vi: set ft=ruby :

$script = <<SCRIPT
set -e
set -x
cd
sudo apt-get update -y
sudo apt-get install \
  git-core \
  curl \
  zlib1g-dev\
  build-essential\
  libssl-dev\
  libreadline-dev\
  libyaml-dev\
  libsqlite3-dev\
  sqlite3\
  libxml2-dev\
  libxslt1-dev\
  libcurl4-openssl-dev\
  python-software-properties \
  -y 2> /dev/null
# install Postgres
sudo sh -c "echo 'deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main' > /etc/apt/sources.list.d/pgdg.list"
wget --quiet -O - http://apt.postgresql.org/pub/repos/apt/ACCC4CF8.asc | sudo apt-key add -
sudo apt-get update -y
sudo apt-get install postgresql-common postgresql-9.3 libpq-dev -y 2> /dev/null
# create Postgres User
sudo -u postgres createuser vagrant -s
# Set super unsafe defaultz (dev only)
sudo sh -c "echo 'local all all trust\nhost all all 127.0.0.1/32 trust\nhost all all ::1/128 trust' > /etc/postgresql/9.3/main/pg_hba.conf "
sudo /etc/init.d/postgresql reload
# install node (the rails asset pipeline need it)
sudo add-apt-repository ppa:chris-lea/node.js -y
sudo apt-get update -y
sudo apt-get install nodejs -y 
# install rbenv
git clone git://github.com/sstephenson/rbenv.git ~/.rbenv
git clone git://github.com/sstephenson/ruby-build.git ~/.rbenv/plugins/ruby-build
# Setup rbenv paths
pathstring='export PATH="$HOME/.rbenv/bin:$HOME/.rbenv/plugins/ruby-build/bin:$PATH"'
eval $pathstring
echo $pathstring >> ~/.bashrc
# Init rbenv
initstring='eval "\$(rbenv init -)"'
echo $initstring >> ~/.bashrc
eval $initstring
# install ruby
rbenv install 2.1.2
rbenv global 2.1.2
ruby -v
echo "gem: --no-ri --no-rdoc" > ~/.gemrc
# install gems
gem install bundler foreman rails
rbenv rehash
SCRIPT

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.box = "ubuntu/trusty64"
  #config.vm.provider "virtualbox" do |v|
  # 	v.gui = true
  # end

  config.vbguest.auto_update = false
  config.vm.network :forwarded_port, guest: 3000, host: 3000

  #if Dir.glob("#{File.dirname(__FILE__)}/.vagrant/machines/default/*/id/*").empty?
    config.vm.provision :shell, inline: $script, privileged: false
  #end

end
