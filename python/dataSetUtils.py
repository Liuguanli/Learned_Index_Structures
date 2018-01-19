#!/usr/bin/python
#coding=utf-8

from bs4 import BeautifulSoup as bs
import requests as req
from pprint import *
import os

# wget -c -O ../data/osm_test.osm "http://api.openstreetmap.org/api/0.6/map?bbox=11.54,48.14,11.543,48.145"

# 下载OSM数据
# os.system('wget -c -O ../data/osm_test.osm "http://api.openstreetmap.org/api/0.6/map?bbox=11.54,48.14,11.543,48.145"')

# 直接读取本地文件，获得范围信息
bsr = bs(open("../data/map.osm"),"lxml")
mbr = bsr.find_all('bounds')
print(mbr)

# 获得osm文件中所有的node对象
nodelist = bsr.find_all('node')

print("All Nodes:",len(nodelist),", list 0-5:")

# 准备写文件

# 打开一个文件
fo = open("../data/nodes.txt", "wb")
for item in nodelist:
    fo.write(item.attrs['id'] + " " + item.attrs['lat'] + " " + item.attrs['lon'] + "\n")
    # print item.attrs['id'], item.attrs['lat'], item.attrs['lon']

# 关闭打开的文件
fo.close()

#print nodelist[0].attrs['lat'], nodelist[0].attrs['lon']


