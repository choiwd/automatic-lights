/* 
 * Código Arduino para o 
 * trabalho Automatic Lights
 * cadeira de Sistemas Embutidos 
 * realizado pelo Grupo 2
 */
 
const int LAMPADA = 12; // pin associado a lâmpada
const int infraRedChange = 400;  // limit for when we know someone passed the sensor
const int lightLimit = 700;   // limit for the light sensor
int lightLevel = 0;  // 1 if sensorLight > lightLimit (to much light to switch on LAMPADA)
                     // 0 if sensorLight =< lightLimit (can switch on LAMPADA)
unsigned long tick = 0;
int passed = 0;
unsigned long tempo;
unsigned long deb;
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

  if (tempo-deb > 500 and light!=2){
      lightLevel=light;
      Serial.println(lightLevel);
      light=2;
      deb=0;
  }
  if (sensorLight > lightLimit and lightLevel == 0){
      if (light==0) {
        light=2;
        deb = 0;
      }
      if (light==2){
        light=1;
        deb = millis();
      }
  } else if (sensorLight > lightLimit and lightLevel == 1 and light==0) {
      light=1;
  } else if (sensorLight < lightLimit and lightLevel == 1) {
      if (light==1) {
        light=2;
        deb = 0;
      }
      if (light==2){
        light=0;
        deb = millis();
      }
  } else if (sensorLight < lightLimit and lightLevel == 0 and light==1) {
      light=0;
    }

  if (tempo-tick > 4000) {
    tick = 0;
    passed = 0;
  }
  if (sensorInfraRed1 > infraRedChange and tick==0 and passed==0){
    passed = 1;
    tick = millis();
  } else if (sensorInfraRed1 > infraRedChange and tick != 0 and passed == 2) {
    Serial.println("Entered");
    delay(1000);
    passed = 0;
    tick = 0;
  } else if (sensorInfraRed2 > infraRedChange and tick==0 and passed==0) {
    passed = 2;
    tick = millis();
  } else if (sensorInfraRed2 > infraRedChange and tick != 0 and passed == 1) {
    Serial.println("Left");
    delay(1000);
    passed = 0;
    tick = 0;
  }

  if (Serial.available() > 0){
    int command = Serial.read()-'0';
    if (command==1){
      digitalWrite(LAMPADA, HIGH);  
    } else if (command==0) {
      digitalWrite(LAMPADA, LOW);
    }
  }

  // digitalWrite(LAMPADA, LOW);
  // delay(1000);
  // digitalWrite(LAMPADA, HIGH);
  // delay(1000);
  // print out the value you read:
 /* Serial.print(sensorInfraRed1);
  Serial.print(", ");
  Serial.print(sensorInfraRed2);
  Serial.print(", ");
  Serial.print(sensorLight);
  Serial.print("\n");
  delay(1);        // delay in between reads for stability*/
}
