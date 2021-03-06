#! /usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = "Tokuume Shinya<g1244785@cc.kyoto-su.ac.jp>"
__status__ = "production"
__date__ = "22 December 2014"


from primeministers import reader
from primeministers import tuple
from primeministers import table
from primeministers import io
import os
import re
import shutil
import time
import urllib2




class Downloader(io.IO):
	"""ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。"""
	
	def __init__(self,base_directory):
		"""ダウンローダのコンストラクタ。"""
		self._base_directory = base_directory
		self._csv_file_name = "PrimeMinisters.csv"
	
	def download_all(self):
		"""すべてをダウンロードする """
		self.download_csv()
		csv_file = self.read_csv(os.path.join(self._base_directory,"csv",self._csv_file_name))
		a_reader = reader.Reader(csv_file)
	 	a_table = a_reader.table()
		images_names = a_table.image_filenames()
		images_thumnail = a_table.thumbnail_filenames()
		for image in images_names:
			self.download_images(image)
		for thumbnail in images_thumnail:
			self.download_images(thumbnail)
		return a_table
	
	def download_csv(self):
		"""csvファイルをダウンロードする """
		a_url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/PrimeMinisters.csv"
		opener = urllib2.build_opener()
		download_path = os.path.join(self._base_directory,"csv")
		if not os.path.exists(download_path):
			print "Create Directory..."+str(download_path)
			os.makedirs(download_path)
		a_request = urllib2.Request(a_url,headers={'User-Agent':"Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:33.0) Gecko/20100101 Firefox/33.0"})
		try:
			self._csv_file = open(os.path.join(download_path,self._csv_file_name),'wb')
		except IOError:
			print 'IOError!!!!!!!'
			return None
		try:
			a_csv = opener.open(a_request).read()
		except urllib2.HTTPError, e:
			print 'Cannot Open This Page'
			print 'Error Code',e.code
			return None
		self._csv_file.write(a_csv)
		self._csv_file.close()
		print 'End Download CSV File.'
		return None

	def download_images(self,image_filename):
		"""画像をダウンロードする """
		#time.sleep(1) #1秒だけ待つ
		image_pat = re.compile('images/')
		thumbnail_pat = re.compile('thumbnails/')
		a_url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/"+str(image_filename)
		opener = urllib2.build_opener()
		if not image_pat.search(image_filename) == None: 
			download_path = os.path.join(self._base_directory,"images")
			if not os.path.exists(download_path):
				print "Create Directory..."+str(download_path)
				os.makedirs(download_path)
		elif not thumbnail_pat.search == None:
			download_path = os.path.join(self._base_directory,"thumbnails")
			if not os.path.exists(download_path):
				print "Create Directory..."+str(download_path)
				os.makedirs(download_path)
		else:
			print 'This file is NOT exists!!'
			
		a_request = urllib2.Request(a_url,headers={'User-Agent':"Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:33.0) Gecko/20100101 Firefox/33.0"})
		try:
			self._image_file = open(os.path.join(self._base_directory,image_filename),'wb')
		except IOError:
			print 'IOError!!!!!!!'
			return None
		try:
			a_image = opener.open(a_request).read()
		except urllib2.HTTPError, e:
			print 'Cannot Open This Page'
			print 'Error Code',e.code
			return None
		self._image_file.write(a_image)
		self._image_file.close()
		print 'End Download image File.'
		return None

		return None
		
		
	
				 
