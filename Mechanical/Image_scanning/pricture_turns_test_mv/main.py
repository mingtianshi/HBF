import numpy as np
from PIL import ImageGrab
import cv2
import time

def proccess_img(original_image):
  proccess_img = cv2.cvtColor(original_image, cv2.COLOR_BGR2GRAY)
  proccess_img = cv2.Canny(proccess_img, threshold1=200 , threshold2=300)
  return proccess_img
last_time = time.time()

while(True):
  screen = np.array(ImageGrab.grab(bbox=(0,40,800,640)))
  new_screen = proccess_img(screen)
  print('Loop took () seconds'.format(time.time() - last_time))
  last_time = time.time()
  cv2.imshow('window2', new_screen)

  # cv2.imshow('window2', cv2.cvtColor(screen,cv2.COLOR_BGR2RGB))

  if cv2.waitKey(25) & 0xFF == ord('q'):
    cv2.destroyAllWindows()
    break