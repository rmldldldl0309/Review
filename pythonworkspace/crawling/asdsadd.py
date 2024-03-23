from bs4 import BeautifulSoup
import requests
import pandas as pd
import datetime

from selenium import webdriver
import time


path = './lib/chromedriver.exe'
driver = webdriver.Chrome(path)

url = 'https://www.coffeebeankorea.com/store/store.asp'
def coffeebean_store(result):
    for i in range(1, 6):
        driver.get(url)
        time.sleep(1) #웹 페이지 연결한 동안 1초 대기
        try:
            driver.execute_script('storePop2(%d)' % i)
            time.sleep(1)

            source = driver.page_source
            soupCB = BeautifulSoup(source,'lxml')

            #매점명
            store_name_h2 = soupCB.select_one('div.store_txt > h2').text

    #         print(store_name_h2)

            #매점 주소
            store_info_add = soupCB.select_one('div.store_txt>table.store_table>tbody>tr:nth-of-type(3)>td')
            store_address = store_info_add.text
    #         print(store_address)

            #매점 전화번호

            store_info_phone = soupCB.select_one('div.store_txt>table.store_table>tbody>tr:nth-of-type(4)>td')
            store_phone = store_info_phone.text
    #         print(store_phone)

            #result에 매점정보 저장
            result.append([store_name_h2] + [store_address] + [store_phone])
        except:
            continue

def main():
    result = []
    coffeebean_store(result)

    cb_tbl = pd.DataFrame(result, columns=['store','address','phone'])
    cb_tbl.to_csv('./data_crowling/CoffeeBean.csv', encoding='cp949', index = True )
    
if __name__ == '__main__':
    main()
    