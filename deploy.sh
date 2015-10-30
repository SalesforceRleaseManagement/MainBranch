#!/bin/bash
#git clone https://github.com/SalesforceRleaseManagement/MainBranch
cd ./MainBranch/instruere
echo $PWD
maven clean
maven install
echo "Depoying Salesforce server and client packages"
maven exec:java
echo $PWD
echo "Deploying application on heroku"
HEROKU_API_KEY="c38db612-63d7-45b3-a3f1-83a51d38ecff" mvn heroku:deploy-war

