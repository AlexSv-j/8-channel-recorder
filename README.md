# 8-channel-recorder
DC voltage measuring device

The digital recorder is designed to measure DC voltages in the range of 0 - 30V. The recorder is equipped with 8 channels and can measure voltages simultaneously on 8 devices. The voltage on each channel is measured 64 times per second.

The file "Firmware for microcontroller Atmega16.txt" contains the firmware for the Atmega16 microcontroller. This firmware is written in the free version of the CodeVisionAVR program. 
To program the microcontroller you need: 
1. Compile a .hex file in CodeVisionAVR; 
2. Using USB ISP USBasp programmer (https://aliexpress.ru/item/1005002024258831.html) you should program microcontroller using .hex file.

The electronic circuit of the recorder is presented in the file "Scheme of the recorder.jpg" with all elements and their ratings.
You can see an example of the circuit board in the files "PCB for USB connector.jpg" and "PCB for USB connector (mirror).jpg". You will get the real size of the PCB if you print the required PCB photo on an A4 sheet.

On the printed circuit board a mounting location for a CH340G UART to USB converter (https://www.aliexpress.com/item/4001256074639.html) is prepared. After connecting the CH340G converter you need to install the drivers. 
After making the recorder and connecting it to the computer, there will be a virtual COM-port for which you need to install:
BAUDRATE 57600, DATABITS 8, STOPBITS 1, PARITY_NONE.
