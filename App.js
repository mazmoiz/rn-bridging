/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, { useState } from 'react';
import type { Node } from 'react';
import {
  Dimensions,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import Slider from '@react-native-community/slider';

import PathAnimationView from './src/components/PathAnimation'

const App: () => Node = () => {

  const { height, width } = Dimensions.get("window");
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
    height: height
  };

  const [sides, setSides] = useState(10);
  const [radius, setRadius] = useState(200);
  const [lineThickness, setLineThickness] = useState(15);

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />

      <Text style={styles.sectionTitle}>DRAW SHAPES</Text>
      <PathAnimationView radius={radius} sides={sides} lineThickness={lineThickness}
        style={{
          height: width,
          width: width,
          alignContent: 'center',
          alignItems: 'center',
        }}>
      </PathAnimationView>

      <Text style={styles.sectionTitle}></Text>
      <View style={{ height: 100 }}>
        <Text style={styles.title}>SIDES</Text>
        <Slider
          style={{ width: width, height: 40 }}
          minimumValue={3}
          maximumValue={50}
          minimumTrackTintColor="#F4D03F"
          maximumTrackTintColor="#000000"
          thumbTintColor='#F4D03F'
          step={1}
          value={sides}
          onValueChange={(v) => {
            setSides(v)
          }}
        />
        <Text style={{ marginLeft: 10 }}>{sides}</Text>
      </View>

      <View style={{ height: 100 }}>
        <Text style={styles.title}>RADIUS</Text>
        <Slider
          style={{ width: width, height: 40 }}
          minimumValue={50}
          maximumValue={450}
          minimumTrackTintColor="#F4D03F"
          maximumTrackTintColor="#000000"
          thumbTintColor='#F4D03F'
          step={1}
          value={radius}
          onValueChange={(v) => {
            setRadius(v)
          }}
        />
        <Text style={{ marginLeft: 10 }}>{radius}</Text>
      </View>

      <View style={{ height: 100 }}>
        <Text style={styles.title}>LINE THICKNESS</Text>
        <Slider
          style={{ width: width, height: 40 }}
          minimumValue={5}
          maximumValue={50}
          minimumTrackTintColor="#F4D03F"
          maximumTrackTintColor="#000000"
          thumbTintColor='#F4D03F'
          step={1}
          value={lineThickness}
          onValueChange={(v) => {
            setLineThickness(v)
          }}
        />
        <Text style={{ marginLeft: 10 }}>{lineThickness}</Text>
      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  slider: {
    fontSize: 24,
    fontWeight: '600',
  },
  customView: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    alignSelf: 'center'
  },
  title: {
    marginLeft: 10,
    fontWeight: '700'
  },
  sectionTitle: {
    margin: 10,
    fontWeight: '700'
  },
});

export default App;
