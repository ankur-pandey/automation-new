from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
import xlrd
import time





#add chromedriver path 
driver=webdriver.Chrome('/usr/lib/chromium-browser/chromedriver')
driver.get("http://krmct002.kartrocket.com/login")
driver.implicitly_wait(30)
driver.maximize_window()



# read data from excel
book = xlrd.open_workbook("/home/ankkur/Desktop/testdata.xls") # in my case the directory contains the excel file named excel.xls
sheet=book.sheet_by_index(0)
row=sheet.nrows
print row-1

timestr = time.strftime("%Y%m%d-%H%M%S")


with open('/home/ankkur/Desktop/'+timestr+'_login'+'.csv', 'a') as the_file:

    for i in range(1,row):
        username= (sheet.cell_value(i,0))
        password1= (sheet.cell_value(i,1))
        password=(str(password1).rstrip('.0'))
        print (str(password1).rstrip('.0'),username)

        driver.implicitly_wait(10)


        driver.find_element_by_xpath("/html/body/div[3]/div/div[1]/div[1]/div[1]/div[2]/form/div[1]/input").clear()
        driver.find_element_by_xpath("/html/body/div[3]/div/div[1]/div[1]/div[1]/div[2]/form/div[1]/input").send_keys(username)
        driver.find_element_by_xpath("/html/body/div[3]/div/div[1]/div[1]/div[1]/div[2]/form/div[2]/input").clear()
        driver.find_element_by_xpath("/html/body/div[3]/div/div[1]/div[1]/div[1]/div[2]/form/div[2]/input").send_keys(password)
        #wait=WebDriverWait(driver,10).until(
        #EC.presence_of_element_located((By.XPATH,"button[type=submit]")))
        driver.find_element_by_css_selector("button[type=submit]").click()
        #driver.implicitly_wait(30)
    

        try:
            driver.implicitly_wait(30)
            elem=driver.find_element_by_css_selector("body > div.modal.fade.ng-scope.ng-isolate-scope.in > div > div > div.panel-body.bb0.pt-xl.ph-xl.pb.ng-scope > div > button")
            #driver.switch_to_alert()
            #elem=WebDriverWait(driver,30).until(EC.presence_of_elemenbtn btn btn-primary btn-small mr-lg mb-lgt_located((By.CSS_SELECTOR,"body > div.modal.fade.ng-scope.ng-isolate-scope.in > div > div > div.panel-body.bb0.pt-xl.ph-xl.pb.ng-scope > div > button")))
            #driver.execute_script("return arguments[0].scrollIntoView(true);", elem)

            print (elem.text + '--->>'+'you got weight dispute')
            driver.implicitly_wait(20)
            driver.find_element_by_css_selector("body > div.modal.fade.ng-scope.ng-isolate-scope.in > div > div > div.panel-header.ng-scope > a").click()
            print(driver.find_element_by_class_name("pull-left weight ng-binding").text())
            driver.implicitly_wait(10) 

            #wait=WebDriverWait(driver,10).until(
            #EC.presence_of_element_located((By.XPATH,"button[type=submit]")))


            driver.find_element_by_css_selector("#app\2e processing")
            #print elem1


           # else:
            #    print "no element "

        except:
            print ("no alert for user" + ' --->>>' + username )           
            
        try:    
            driver.find_element_by_id("recharge-btn").is_displayed()
            the_file.write( username +',' + password  +',' + 'the test case has passed\n')



        except:
            the_file.write(username +',' + password  +',' + 'the test case has failed\n')
            print "lost" 
            driver.implicitly_wait(10)
        


    

    
    
    
    #driver.close()











