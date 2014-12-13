package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;

import views.html.*;

public class Application extends Controller {

    static Form<HadoopInfo> hadoopForm = Form.form(HadoopInfo.class);

    public static Result index() {
        //return ok(index.render("Your new application is ready."));
        return redirect(routes.Application.submit());
    }

    public static Result hadoop() {
        return ok(
                views.html.index.render("Submit Hadoop Job", hadoopForm)
                );
    }

    public static Result submit() {
        Form<HadoopInfo> filledForm = hadoopForm.bindFromRequest();
        HadoopInfo.submit(filledForm.get());
        return redirect(routes.Application.submit());
    }

}
