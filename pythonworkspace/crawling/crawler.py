# ▶ 웹 스크래핑 (Scrapping): 웹 페이지의 응답을 받아 데이터를 분석하여 필요한 데이터를 수집하는 방법
# 파이썬 스크래핑 패키지: beautifulsoup4
# pip install beautifulsoup4

# pip install requests
import requests
from bs4 import BeautifulSoup

URL = 'https://naver.com'

# response - status code  
# 100: 추가 요청 기다림 / 200: 성공 / 300: 리소스 위치 변경됨 / 400: 요청자(클라이언트) 오류 / 500: 응답자(서버) 오류
# response = requests.get(URL)

# if response.status_code == 200:
#     html = response.text
#     soup = BeautifulSoup(html, 'html.parser')
#     a_list = soup.find_all('a')
# else:
#     print(response.status_code)

# ==============================================================================================================================
# ▶ 웹 크롤링 (Crawling): 에
# 파이썬 크롤링 패키지: selenium
# pip install selenium

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver import ActionChains
import time

driver = webdriver.Chrome()

driver.get(URL)
time.sleep(1)

search_input = driver.find_element(By.ID, 'query')
search_input.send_keys('제네시스')
time.sleep(1)

search_input.send_keys(Keys.ENTER)
time.sleep(1)

news_button = driver.find_element(By.CSS_SELECTOR, '#lnb > div.lnb_group > div > div.lnb_nav_area._nav_area_root > div > div.api_flicking_wrap._conveyer_root > div:nth-child(8) > a')
time.sleep(1)

ActionChains(driver).click(news_button).perform()
time.sleep(2)

news_title_elements = driver.find_elements(By.CLASS_NAME, 'news_tit')
time.sleep(1)

for news_title_element in news_title_elements:
    # title = news_title_element.text
    title = news_title_element.get_attribute('title')
    print(title)
    
time.sleep(1)

driver.back()
time.sleep(1.5)

image_button = driver.find_element(By.XPATH, '//*[@id="lnb"]/div[1]/div/div[1]/div/div[1]/div[1]/a')
time.sleep(1)

ActionChains(driver).click(image_button).perform()
time.sleep(1.5)

image_elements = driver.find_elements(By.CLASS_NAME, '_fe_image_tab_content_thumbnail_image')
time.sleep(1)

image_list = []

for image_element in image_elements:
    image_src = image_element.get_attribute('src')
    image_list.append(image_src)
time.sleep(1)

# # 파이썬으로 폴더 생성
# import os

# FOLDER_PATH = r'../images/'

# if not os.path.isdir(FOLDER_PATH):
#     os.mkdir(FOLDER_PATH)
# # -------------------

# # 파이썬으로 이미지 URL 파일 다운로드
# from urllib.request import urlretrieve

# number = 1

# for image_src in image_list:
#     urlretrieve(image_src, FOLDER_PATH + f'{number}.png') 
#     number += 1
#     time.sleep(0.5)
