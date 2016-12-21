Class Practice 7

- Headless Fragment(RetainState)
- Asynctask class and methods
- Service
- ProgressBar (Updated by AsycnTask method)

Notes:
- Headless fragment: Which retains the fragment content on rotating the device.
- Asynctask: Problem is with memory leaks. What if it takes a while for the REST api call and the activity may be destroyed.
- ProgressBar
- Services: Spotify player in the notification area uses a foregroundservice.
Types:
Intent Service, like updating database.
Started Service, Play music.
Bound Service, other activities are bound to one service for info.
