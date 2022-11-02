# Web App for Energy Utility Monitoring

To start up the application with Docker, please follow these steps:

(Prerequisites: Docker and git installed)

1. clone the repository
> git clone https://github.com/bori00/EnergyUtilityPlatform.git


2. enter the directory (corresponding to the back-end)
> cd EnergyUtilityPlatform


3. build the image for the backend and the database
> sudo docker build -t energy-utility-backend .


4. start the image for the backend
> sudo docker-compose up


5. enter the directory of the frontend
> cd react-client


6. build the image for the frontend
> sudo docker build -t energy-utility-frontend .


7. start the image for the frontend
> sudo docker-compose up


8. Congrats! Access the application at lohalcost
