# Fetch Rewards Coding Exercise - Android App

This Android app retrieves data from the provided API and displays a list of items grouped by "listId". It also sorts the results first by "listId" and then by "name" when displaying. Additionally, it filters out any items where "name" is blank or null.

## Requirements

- Android Studio 
- Android SDK with minimum SDK version 24

## Getting Started

1. Clone the repository:
   
   `git clone https://github.com/yourusername/fetch-rewards-android.git`

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

## Usage

The app will make an API call to retrieve the data and display it in an easy-to-read list. Each item is grouped by "listId" and sorted first by "listId" and then by "name".

## Features

- Retrieving data from API.
- Grouping items by "listId".
- Sorting items by "listId" and "name".
- Filtering out items with blank or null "name".

## Project Structure

- `app/src/main/java/com/example/fetchchallengeapplication`
  - `models`: Contains the data model (`ItemModel`) for the items.
  - `network`: Contains the ApiService interface,  RetrofitInstance and repository for making API calls.
  - `userinterface/activities`: Contains the `Activities` of the app.
  - `userinterface/screens`: Contains the `Jetpack Compose` functions for displaying data onto UI.
  - `viewmodels`: Contains the `ItemViewModel` for managing data operations and providing data to the UI.
- `app/src/main/res`: Contains resources like layouts, strings, and drawables.

## Libraries Used

- Retrofit: For making network calls.
- Gson: For JSON serialization/deserialization.
- AndroidX: For various Android support libraries.
- Jetpack Compose: For building the UI.

## Acknowledgements

- Thanks to Fetch Rewards for providing this coding exercise.
