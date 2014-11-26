#! /usr/bin/env python
# -*- coding: utf-8 -*-

import os
import shutil
import urllib2

import io
import reader

class Downloader(io.IO):
	"""ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。"""

	def __init__(self, base_directory):
		"""ダウンローダのコンストラクタ。"""
		self._base_directory = base_directory
		return base_directory

	def download_all(self):
		"""すべて（総理大臣の情報を記したCSVファイル・画像ファイル群・縮小画像ファイル群）をダウンロードし、テーブルを応答する。"""
		thumbnail_files = []
		img_files = []
		a_ksu_url = "http://www.cc.kyoto-su.ac.jp/~athushi/Programs/CSV2HTML/PrimeMinisters/"

		if not os.path.exists(os.path.join(self._base_directory,"images")):
			os.mkdir(base_directory+"/images")
			a_image_directory = os.path.join(self._base_directory,"images")

		if not os.path.exists(os.path,join(self._base_directory,"thumbnails")):
			os.mkdir(os.path,join(self._base_directory,"thumbnails")
			a_thumbnail_directory = base_directory+"/thumbnails"

		for index in range(39,63):
			"""後ほど改善総理大臣が増えた時にめんどくさい"""
			a_image_url = a_ksu_url+"0"+str(index)+".jpg"
			a_thumbnail_url = a_ksu_url+"0"+str(index)+".jpg"
			opener = urllib2.build_opener()
			thumbnail_request = urllib2.Request(a_thumbnail_url,headers={'User-Agent : "Magic Browser"'})
			thumbnail_file = open(base_directory+"/thumbnail/"+str(index)+".jpg",'wb')
			thumbnail_file.write(opener.open(thumbnail_request).read())
			thumbnail_files.append(thumnail_file)
			thumbnail_file.close()

			img_file = open(bese_directory+"/images/"+str(index)+".jpg",'wb')
			img_file.write(opener.open(request).read())
			img_files.append(ima_file)
			img_file.close()

		a_csv_url = a_ksu_url+"PrimeMinisters.csv"
		request_csv = urllib2.Request(a_csv_url,headers={'User-Agent' : 'Magic Browser'})
		csv_file = open(bese_directory,'wb')
		csv_file.write(opener.open(request_csv).read())
		csv_file.close()			
		return None

	def download_csv(self):
		"""総理大臣の情報を記したCSVファイルをダウンロードする。"""
		a_ksu_url = "http://www.cc.kyoto-su.ac.jp/~athushi/Programs/CSV2HTML/PrimeMinisters/"
		a_csv_url = a_ksu_url+"PrimeMinisters.csv"
		request_csv = urllib2.Request(a_csv_url,headers={'User-Agent' : 'Magic Browser'})
		csv_file = open(bese_directory,'wb')
		csv_file.write(opener.open(request_csv).read())
		csv_file.close()	
		return None
	def download_images(self, image_filenames):
		"""画像ファイル群または縮小画像ファイル群をダウンロードする。"""
	       	a_ksu_url = "http://www.cc.kyoto-su.ac.jp/~athushi/Programs/CSV2HTML/PrimeMinisters/"
		if not os.path.exists(base_directory+"/images"):
			os.mkdir(base_directory+"/images")
			a_image_directory = base_directory+"/images"
		if not os.path.exists(base_directory+"/thumbnails"):
			os.mkdir(base_directory+"/thumbnails")
			a_thumbnail_directory = base_directory+"/thumbnails"
		for index in range(39,63):
			"""後ほど改善総理大臣が増えた時にめんどくさい"""
			a_image_url = a_ksu_url+"0"+str(index)+".jpg"
			a_thumbnail_url = a_ksu_url+"0"+str(index)+".jpg"
			opener = urllib2.build_opener()
			request = urllib2.Request(a_url,headers={'User-Agent' : "Magic Browser"})
			thumbnail_request = urllib2.Request(a_thumbnail_url,headers={'User-Agent : "Magic Browser"'})
			thumbnail_file = open(base_directory+"/thumbnail/"+str(index)+".jpg",'wb')
			thumbnail_write(opener.open(thumbnail_request).read())
			thumbnail_file.close()
			img_file = open(bese_directory+"/images/"+str(index)+".jpg",'wb')
			img_file.write(opener.open(request).read())
			img_file.close()
		return None
