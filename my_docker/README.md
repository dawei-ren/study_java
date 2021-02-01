

打包
docker build -t test3 .
docker run -it --rm -e NAME=dawei -e AGE=10 test3