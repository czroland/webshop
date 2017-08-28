package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.ProductImageService;
import hu.schonherz.java.summer.project.service.api.service.ProductService;
import hu.schonherz.java.summer.project.service.api.vo.ProductImageVo;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBCategory;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBProduct;
import lombok.Data;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component(value = "productUploadBean")
@Scope("request")
@Data
public class MBProductUpload {

    @Autowired
    private MBProduct product;
    @Autowired
    private MBCategory category;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public void doCreate() {
        product.getProduct().setCategory(category.getCategory());
        product.getProduct().setSubCategory(category.getSubCategory());
        productService.saveProduct(product.getProduct());
        product.init();
    }

    public void fileUpload(FileUploadEvent event) {

        FacesMessage message;
        try {
            createFile(event.getFile().getFileName(), event.getFile().getInputstream());

            message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        } catch (IOException e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed uploading.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void createFile(String fileName, InputStream input) throws IOException {
        Path absPath = Paths.get(createDir() + File.separator + fileName);
        Files.copy(input, absPath, StandardCopyOption.REPLACE_EXISTING);
        saveImage(absPath.toString(), fileName);
    }

    public void saveImage(String path, String fileName) {
        ProductImageVo productImageVo = new ProductImageVo();
        productImageVo.setName(fileName);
        productImageVo.setRoot(path);
        product.getProduct()
            .getImages()
            .add(productImageVo);
    }

    public File createDir() {
        File destination = new File(System.getProperty("user.home") + File.separator +
            "backoffice" + File.separator + product.getProduct().getNumber().toString());
        if (!destination.exists()) {
            destination.mkdirs();
        }
        return destination;
    }
}
