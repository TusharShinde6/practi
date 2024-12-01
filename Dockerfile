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

# Install Chrome (Specify a specific version for stability)
ARG CHROME_VERSION=119.0.6446.79  # Replace with desired Chrome version
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list' \
    && apt-get update && apt-get install -y google-chrome-$CHROME_VERSION

# Install ChromeDriver (Specify a specific version for stability)
ARG CHROME_DRIVER_VERSION=119.0.6446.79  # Replace with desired ChromeDriver version
RUN wget -q https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && mv chromedriver /usr/bin/chromedriver \
    && chmod +x /usr/bin/chromedriver \
    && rm chromedriver_linux64.zip