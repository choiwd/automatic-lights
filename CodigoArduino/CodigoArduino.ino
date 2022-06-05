/* 
 * Código Arduino para o 
 * trabalho Automatic Lights
 * cadeira de Sistemas Embutidos 
 * realizado pelo Grupo 2
 */
 
const int LAMPADA = 12; // pin associado a lâmpada
const int infraRedChange = 400;  // limit for when we know someone passed the sensor
const int lightLimit = 700;   // limit for the light sensor
int lightLevel = 0;  // 0 if sensorLight > lightLimit (to much light to switch on LAMPADA)
                     // 1 if sensorLight =< lightLimit (can switch on LAMPADA)
unsigned long tempoInfrRed = 0;
unsigned long tempo;
unsigned long tempoLuz;
int passed = 0;
int light = 2;


void setup() {
  Serial.begin(115200); // initialize serial communication at 115200 bits per second:
  pinMode(LAMPADA, OUTPUT);
}

void loop() {
  int sensorInfraRed1 = analogRead(A0); 
  int sensorInfraRed2 = analogRead(A1);
  int sensorLight = analogRead(A2);

  tempo=millis();

 
 
  // ---- Sensor de luz
 
  // quando há mudança no light level, o light level tem de ser 0.5 sec no mesmo threshold 
  // para ser transmitido ao Raspberry Pi
  if (tempo-tempoLuz > 500 and light!=2){
      lightLevel=light;
      Serial.println(lightLevel);
      light=2;
      tempoLuz=0;
  }
  if (sensorLight > lightLimit and lightLevel == 0){
      if (light==0) {
        light=2;
        tempoLuz = 0;
      }
      if (light==2){
        light=1;
        tempoLuz = millis();
      }
  } else if (sensorLight > lightLimit and lightLevel == 1 and light==0) {
      light=1;
  } else if (sensorLight < lightLimit and lightLevel == 1) {
      if (light==1) {
        light=2;
        tempoLuz = 0;
      }
      if (light==2){
        light=0;
        tempoLuz = millis();
      }
  } else if (sensorLight < lightLimit and lightLevel == 0 and light==1) {
      light=0;
    }

 
 
  // ---- Sensores infravermelhos
 
  // depois de 4sec voltar como se ninguem passou por um sensor infravermenlho
  if (tempo-tempoInfrRed > 4000) { 
    tempoInfrRed = 0;
    passed = 0;
  }
  if (sensorInfraRed1 > infraRedChange and tempoInfrRed==0 and passed==0){
    passed = 1;
    tempoInfrRed = millis();
  } else if (sensorInfraRed1 > infraRedChange and tempoInfrRed != 0 and passed == 2) {
    Serial.println("Entered");
    delay(1000);
    passed = 0;
    tempoInfrRed = 0;
  } else if (sensorInfraRed2 > infraRedChange and tempoInfrRed==0 and passed==0) {
    passed = 2;
    tempoInfrRed = millis();
  } else if (sensorInfraRed2 > infraRedChange and tempoInfrRed != 0 and passed == 1) {
    Serial.println("Left");
    delay(1000);
    passed = 0;
    tempoInfrRed = 0;
  }
 
 
 
  // ---- Ligar desligar a luz
 
  if (Serial.available() > 0){
    int command = Serial.read()-'0';
    if (command==1){
      digitalWrite(LAMPADA, HIGH);  
    } else if (command==0) {
      digitalWrite(LAMPADA, LOW);
    }
  }
}
