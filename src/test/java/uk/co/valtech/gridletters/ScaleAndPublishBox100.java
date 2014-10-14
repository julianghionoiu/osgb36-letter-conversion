package uk.co.valtech.gridletters;

/**
* Created by julianghionoiu on 14/10/2014.
*/
class ScaleAndPublishBox100 implements ProcessingStep {
    @Override
    public OsgbPoint process(OsgbPoint currentPoint, StringBuilder sb) {
        currentPoint = currentPoint.scaleInside(Scale.KM_500);
        sb.append(LetterTable.getLetterFor(currentPoint, Scale.KM_100));
        return currentPoint;
    }
}
