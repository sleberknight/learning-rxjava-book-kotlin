package ch02

import io.reactivex.Observable
import javafx.application.Application
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton
import javafx.scene.layout.VBox
import javafx.stage.Stage

fun main(args: Array<String>) {
    Application.launch(Ex11HotObservableJavaFxApp::class.java)
}

class Ex11HotObservableJavaFxApp : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {

        val toggleButton = ToggleButton("Toggle Me")
        val label = Label()

        val selectedStates = valuesOf(toggleButton.selectedProperty())

        selectedStates.map { selected -> if (selected) "Down" else "Up" }
                .subscribe(label::setText)

        val vBox = VBox(toggleButton, label)

        primaryStage.scene = Scene(vBox)
        primaryStage.show()
    }

    private fun <T> valuesOf(fxObservable: ObservableValue<T>): Observable<T> {
        return Observable.create { emitter ->

            // emit initial state
            emitter.onNext(fxObservable.value)

            // emit value changes using a listener
            val listener = ChangeListener<T> { _, _, newValue -> emitter.onNext(newValue) }

            fxObservable.addListener(listener)
        }
    }

}
