### Task-4: Data Fetching and Manipulation from the Internet
In this task, I learned how to fetch data from the internet and display it in the UI by parsing the retrieved data. I enabled the display of data obtained from the chosen API in a list format and facilitated navigation to a detail page.

## Used API:
The Movie Database API

## Actions Taken
1-Making Network Requests with Retrofit: I sent requests to the API using Retrofit and received the incoming data. I prepared this data for display in the application's UI layer.

2-Parsing Data with GSON: I parsed the JSON data received from the API into model classes using GSON, making the data processable within the application.
Displaying a List: I displayed the retrieved data in a list format on the screen using RecyclerView. To enhance UI performance, I utilized ViewHolder and Adapter classes.

3-Detail Page: When an item from the list was clicked, I redirected the user to a detail page to show the details of the selected item. Data passing between fragments was managed using Jetpack Navigation.

## Technologies Used
-Retrofit: Used for network requests.

-GSON: Used to parse JSON data.

-Glide: Used for loading images retrieved from the API.

-LiveData: Used to manage data flow and update the UI state.

-Jetpack Navigation: Used for transitioning between fragments and data passing.

## UI Design

| List            | Detail                                                     | Favorites                |
| ----------------- | ---------------------------------------------------------|-------------------------|
| <img src="./img/Screenshot_1726480457.png" width="50%" height="50%">  | <img src="./img/Screenshot_1726480517.png" width="50%" height="50%"> | <img src="./img/Screenshot_1726480486.png" width="50%" height="50%">

