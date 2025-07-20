FROM ubuntu:20.04


    
# Install wget, unzip, fonts and other dependencies for Chrome
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk maven wget unzip curl gnupg fonts-liberation libnss3 libgconf-2-4 \
    libxss1 libappindicator3-1 libatk-bridge2.0-0 libgtk-3-0 \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# Install Google Chrome stable
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

RUN wget -O /tmp/chromedriver.zip https://storage.googleapis.com/chrome-for-testing-public/138.0.7204.157/linux64/chromedriver-linux64.zip && \
    unzip /tmp/chromedriver.zip -d /usr/local/bin/ && \
    mv /usr/local/bin/chromedriver-linux64/chromedriver /usr/local/bin/chromedriver && \
    rm -rf /tmp/chromedriver.zip /usr/local/bin/chromedriver-linux64 && \
    chmod +x /usr/local/bin/chromedriver
    
    
WORKDIR /app

# Copy and build your project
COPY . /app

RUN mvn clean install

CMD ["mvn", "clean", "test"]