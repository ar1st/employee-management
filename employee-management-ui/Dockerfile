FROM node:14

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json into the container
COPY package*.json ./

# Install application dependencies
RUN npm install

# Copy the rest of your application's source code into the container
COPY . .

# Build the React app
RUN npm run build

# Expose the port your React app is running on
EXPOSE 3000

# Define the command to start your React app
CMD ["npm", "start"]