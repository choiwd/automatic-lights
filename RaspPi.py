import serial

arduinoAdr='/dev/ttyACM0'

if __name__ == '__main__':
    ser = serial.Serial(arduinoAdr, 115200, timeout=1)
    ser.reset_input_buffer()

    c=0
    OnOff=False
    intensity=0

    while True:
        if ser.in_waiting > 0:
            line = ser.readline().decode('utf-8').rstrip()

        if line=="Entered":
            c+=1
        if line=="Left":
            c-=1

        if line=="0":
            intensity=0
        if line=="1":
            intensity=1

        if c==0 and OnOff==True:
            OnOff=False
            command=0
            ser.write(str(command).encode('utf-8'))
            print("Desliga a luz")

        if c>0 and OnOff==False and intensity==1:
            OnOff=True
            command=1
            ser.write(str(command).encode('utf-8'))
            print("Liga a luz")

        print(c)
