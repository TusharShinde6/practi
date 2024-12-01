# Use a newer, LTS version of OpenJDK for better security and performance
FROM openjdk:17-jre-slim-buster

# Install dependencies
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    unzip \
    xvfb \
    libxi6 \
    libgconf-2-4 \
    && apt-get clean

# Install Google Chrome
#RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
#    && sudo dpkg -i google-chrome-stable_current_amd64.deb \
#    && sudo apt-get install -f -y \
#    && rm google-chrome-stable_current_amd64.deb

# Install ChromeDriver (Specify a specific version for stability)
#RUN wget -q https://chromedriver.storage.googleapis.com/114.0.5735.16/chromedriver_linux64.zip \
 #   && unzip chromedriver_linux64.zip \
  #  && mv chromedriver /usr/bin/chromedriver \
   # && chmod +x /usr/bin/chromedriver \
    #&& rm chromedriver_linux64.zip
	
RUN google-chrome-stable --version
RUN chromedriver --version
# Create shared memory folder with appropriate permissions to avoid memory issues
RUN mkdir -p /dev/shm && chmod 1777 /dev/shm