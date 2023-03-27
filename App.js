import React, { useState } from 'react';
import {View, TextInput, StyleSheet, NativeModules, Button} from 'react-native';

const SharedStorage = NativeModules.SharedStorage;

const App = () => {
const [jobName, setJobName] = useState('');
const [eta, setETA] = useState('');
const [locationCoordinates, setLocationCoordinates] = useState('');
const [location, setLocation] = useState('');
const [doneJobs, setDoneJobs] = useState('');
const [totalJobs, setTotalJobs] = useState('');

const widgetData = {
jobName,
eta,
location,
locationCoordinates,
doneJobs,
totalJobs,
};

const handleSubmit = async () => {
// Android
SharedStorage.set(JSON.stringify(widgetData));
};

return (
<View style={styles.container}>
<TextInput
style={styles.input}
onChangeText={newText => setJobName(newText)}
value={jobName}
returnKeyType="send"
placeholder="Enter the job name..."
/>
<TextInput
style={styles.input}
onChangeText={newText => setETA(newText)}
value={eta}
returnKeyType="send"
placeholder="Enter the ETA..."
/>
<TextInput
style={styles.input}
onChangeText={newText => setLocation(newText)}
value={location}
returnKeyType="send"
placeholder="Enter the location..."
/>
<TextInput
style={styles.input}
onChangeText={newText => setLocationCoordinates(newText)}
value={locationCoordinates}
returnKeyType="send"
placeholder="Enter the location coordinates..."
/>
<TextInput
style={styles.input}
onChangeText={newText => setTotalJobs(newText)}
value={totalJobs}
returnKeyType="send"
placeholder="Enter the total number of jobs..."
/>
<TextInput
style={styles.input}
onChangeText={newText => setDoneJobs(newText)}
value={doneJobs}
returnKeyType="send"
placeholder="Enter the number of jobs done..."
/>
<Button
title="Submit"
onPress={handleSubmit}
style={styles.submitButton}
/>
</View>
);
};

export default App;

const styles = StyleSheet.create({
container: {
marginTop: '30%',
paddingHorizontal: 24,
},
input: {
width: '100%',
borderBottomWidth: 1,
fontSize: 20,
minHeight: 40,
marginTop: 24,
},
submitButton: {
marginTop: 24,
},
});