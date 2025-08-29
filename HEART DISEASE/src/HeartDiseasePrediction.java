import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.core.*;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;

public class HeartDiseasePrediction {

    CSVLoader loader = new CSVLoader();
    Instances heartData = null;
    Classifier model = new Logistic();
    String modelPath = "heart_model.model";

    public HeartDiseasePrediction() {
        // Load dataset
        try {
            loader.setSource(new File("heart.csv"));
            heartData = loader.getDataSet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Ensure the class index is set
        if (heartData.classIndex() == -1) {
            heartData.setClassIndex(heartData.numAttributes() - 1);
        }

        // Convert the class attribute to nominal if it's not already
        heartData = convertClassAttributeToNominal(heartData);
        heartData.setClassIndex(heartData.numAttributes() - 1);

        // Check if model file exists, if not, train and save the model
        File modelFile = new File(modelPath);
        if (!modelFile.exists()) {
            trainAndSaveModel();
        } else {
            try {
                model = (Classifier) SerializationHelper.read(modelPath);
                System.out.println("Model loaded successfully from " + modelPath);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load model: " + e.getMessage());
            }
        }
    }

    private void trainAndSaveModel() {
        // Split data for training (80%) and testing (20%)
        int trainSize = (int) Math.round(heartData.numInstances() * 0.8);
        int testSize = heartData.numInstances() - trainSize;
        Instances trainData = new Instances(heartData, 0, trainSize);
        Instances testData = new Instances(heartData, trainSize, testSize);

        // Train model
        try {
            model.buildClassifier(trainData);
            SerializationHelper.write(modelPath, model); // Save the trained model
            System.out.println("Model saved successfully to " + modelPath);
        } catch (Exception e) {
            throw new RuntimeException("Error training and saving model: " + e.getMessage());
        }

        // Evaluate model
        evaluateModel(trainData, testData);
    }

    private void evaluateModel(Instances trainData, Instances testData) {
        try {
            Evaluation eval = new Evaluation(trainData);
            eval.evaluateModel(model, testData);

            System.out.println("=== Model Evaluation ===");
            System.out.println("Accuracy: " + eval.pctCorrect());
            System.out.println("Precision: " + eval.precision(1));
            System.out.println("Recall: " + eval.recall(1));
            System.out.println("F-Measure: " + eval.fMeasure(1));
            System.out.println("Confusion Matrix: ");
            System.out.println(eval.toMatrixString());

            // Additional metric reporting if needed
            System.out.println(eval.toSummaryString("\nSummary of results:\n", false));

        } catch (Exception e) {
            throw new RuntimeException("Evaluation failed: " + e.getMessage());
        }
    }

    public int PredictDisease(int Age, int Sex, int cp, int restbps, int chol, int fastbs, int restecg, int thalach, int exang, float oldpeak, int slope, int ca, int thal) {
        double[] inputData = {Age, Sex, cp, restbps, chol, fastbs, restecg, thalach, exang, oldpeak, slope, ca, thal};

        Instance instance = new DenseInstance(heartData.numAttributes());
        instance.setDataset(heartData);
        for (int i = 0; i < inputData.length; i++) {
            instance.setValue(i, inputData[i]);
        }

        double result = 0;
        try {
            result = model.classifyInstance(instance);
        } catch (Exception e) {
            throw new RuntimeException("Prediction failed: " + e.getMessage());
        }

        return result == 0.0 ? 0 : 1;
    }

    private static Instances convertClassAttributeToNominal(Instances data) {
        if (data.classAttribute().isNominal()) {
            return data;
        }

        FastVector classValues = new FastVector();
        classValues.addElement("0");
        classValues.addElement("1");

        FastVector attributes = new FastVector();
        for (int i = 0; i < data.numAttributes(); i++) {
            attributes.addElement(data.attribute(i));
        }
        attributes.removeElementAt(data.classIndex());

        Attribute nominalClassAttribute = new Attribute("target", classValues);
        attributes.addElement(nominalClassAttribute);

        Instances newData = new Instances(data.relationName(), attributes, data.numInstances());

        for (int i = 0; i < data.numInstances(); i++) {
            Instance oldInstance = data.instance(i);
            Instance newInstance = new DenseInstance(newData.numAttributes());
            newInstance.setDataset(newData);
            for (int j = 0; j < data.numAttributes(); j++) {
                if (j == data.classIndex()) {
                    newInstance.setValue(nominalClassAttribute, String.valueOf((int) oldInstance.value(j)));
                } else {
                    newInstance.setValue(j, oldInstance.value(j));
                }
            }
            newData.add(newInstance);
        }

        newData.setClassIndex(newData.numAttributes() - 1);

        return newData;
    }


    public static void main(String[] args) {
        // Initialize and train the model if not already trained
        HeartDiseasePrediction predictor = new HeartDiseasePrediction();

        // Example usage of PredictDisease
        int prediction = predictor.PredictDisease(63, 1, 3, 145, 233, 1, 0, 150, 0, 2.3f, 0, 0, 1);
        int prediction1 = predictor.PredictDisease(50, 1, 3, 94, 126, 0, 2, 71, 1, 6.0f, 2, 0, 1);
        int prediction2 = predictor.PredictDisease(34, 0, 1, 118, 210, 0, 1, 192, 0, 0.7f, 2, 0, 2);
        System.out.println("Prediction for test data (0 = No Heart Disease, 1 = Heart Disease): " + prediction);
        System.out.println("Prediction for test data (0 = No Heart Disease, 1 = Heart Disease): " + prediction1);
        System.out.println("Prediction for test data (0 = No Heart Disease, 1 = Heart Disease): " + prediction2);
    }
}

